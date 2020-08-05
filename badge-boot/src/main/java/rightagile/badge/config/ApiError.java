package rightagile.badge.config;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.HandlerMethod;
import rightagile.badge.exception.BadgeException;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

@Data
public class ApiError {
    public static final ApiError SPRING_MVC_INTERNAL_ERROR = new ApiError(
            Type.ERROR, "XXX.YYY.01", "스프링 MVC 에러", HttpStatus.NOT_ACCEPTABLE);
    public static final ApiError UNHANDLED_INTERNAL_EXCEPTION = new ApiError(
            Type.SYSTEM_EXCEPTION, "XXX.YYY.02", "직접 관리 되지 않은 예외", HttpStatus.INTERNAL_SERVER_ERROR);
    public static final ApiError UNAUTHORIZED_EXCEPTION = new ApiError(
            Type.SYSTEM_EXCEPTION, "XXX.YYY.03", "Nara Platform 권한 없음", HttpStatus.UNAUTHORIZED);

    public enum Type {
        ERROR, BIZ_EXCEPTION, SYSTEM_EXCEPTION;
    }

    @Data
    class Detail {
        private String request;
        private String handlerClass;
        private String handlerMethod;

        private String exceptionClass;
        private String exceptionMethod;
        private int exceptionCodeLineNumber;

        private Detail() {
            request = "";
            handlerClass = "";
            handlerMethod = "";
        }

        public void setRequest(String request, String handlerClass, String handlerMethod) {
            this.request = request;
            this.handlerClass = handlerClass;
            this.handlerMethod = handlerMethod;
        }

        public void setException(String exceptionClass, String exceptionMethod, int exceptionCodeLineNumber) {
            this.exceptionClass = exceptionClass;
            this.exceptionMethod = exceptionMethod;
            this.exceptionCodeLineNumber = exceptionCodeLineNumber;
        }
    }

    @JsonFormat(pattern = "yyyy-MM-dd kk:mm:ss")
    private LocalDateTime occurredTime;

    private HttpStatus status;
    private Type type;
    private String code;
    private String message;
    private String description;

    @Setter(AccessLevel.PRIVATE)
    private Detail detail;

    private ApiError(Type type, String code, String description, HttpStatus status) {
        this.occurredTime = LocalDateTime.now();
        this.type = type;
        this.code = code;
        this.description = description;
        this.status = status;

        detail = new Detail();
    }

    public ApiError(BadgeException badgeException) {
        this(Type.BIZ_EXCEPTION, badgeException.getType().getCode(), badgeException.getType().getDescription(),
                getHttpStatus(badgeException.getType()));
        this.message = badgeException.getMessage();

        makeExceptionDetail(badgeException);
    }

    private static HttpStatus getHttpStatus(BadgeException.Type type) {
        switch(type) {
            case NOT_FOUND_ENTITY: return HttpStatus.NOT_FOUND;
        }
        return null;
    }

    public ApiError(ApiError predefinedApiError, Exception exception) {
        this(predefinedApiError.getType(), predefinedApiError.getCode(), predefinedApiError.getDescription(),
                predefinedApiError.getStatus());
        this.message = exception.getMessage();
        this.makeExceptionDetail(exception);
    }

    private void makeExceptionDetail(Exception exception) {
        StackTraceElement firstElement = exception.getStackTrace()[0];

        this.detail.setException(firstElement.getClassName(), firstElement.getMethodName(), firstElement.getLineNumber());
    }

    public void makeRequestDetail(WebRequest webRequest, HandlerMethod handlerMethod) {
        Method method = handlerMethod.getMethod();

        this.detail.setRequest(webRequest.getDescription(false), method.getDeclaringClass().getName(), method.getName());
    }
}