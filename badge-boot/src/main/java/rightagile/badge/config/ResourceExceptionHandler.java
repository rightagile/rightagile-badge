package rightagile.badge.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import rightagile.badge.accent.shared.util.exception.NaraException;
import rightagile.badge.exception.BadgeException;

@Slf4j
@ControllerAdvice
public class ResourceExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(
            Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        super.handleExceptionInternal(ex, body, headers, status, request);

        log.error("ResourceExceptionHandler - HandleExceptionInternal", ex);

        ApiError apiError = new ApiError(ApiError.SPRING_MVC_INTERNAL_ERROR, ex);
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleAllException(Exception ex, WebRequest webRequest, HandlerMethod handlerMethod) {
        log.error("ResourceExceptionHandler - HandleAllException", ex);

        ApiError apiError = new ApiError(ApiError.UNHANDLED_INTERNAL_EXCEPTION, ex);
        apiError.makeRequestDetail(webRequest, handlerMethod);
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    @ExceptionHandler(NaraException.class)
    protected ResponseEntity<ApiError> handleNaraException(NaraException ne, WebRequest webRequest) {
        log.error("ResourceExceptionHandler - handleNaraException", ne);

        ApiError apiError = new ApiError(ApiError.UNAUTHORIZED_EXCEPTION, ne);
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    @ExceptionHandler(BadgeException.class)
    protected ResponseEntity<ApiError> handleBusinessLogicException(BadgeException badgeException, WebRequest webRequest, HandlerMethod handlerMethod) {
//        log.error("ResourceExceptionHandler - handleBusinessLogicException", badgeException);

        ApiError apiError = new ApiError(badgeException);
        apiError.makeRequestDetail(webRequest, handlerMethod);
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}