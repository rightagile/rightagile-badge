package rightagile.badge.exception;

public class BadgeException extends RuntimeException {
    public enum Type {
        NOT_FOUND_ENTITY("XXX.XXX.01", "엔터티를 조회할 수 없음");

        private String code;
        private String description;

        Type(String code, String description) {
            this.code = code;
            this.description = description;
        }

        public String getCode() {
            return code;
        }

        public String getDescription() {
            return description;
        }
    }

    private Type exceptionType;

    private BadgeException() {
    }

    public BadgeException(Type exceptionType, String message) {
        super(message);
        this.exceptionType = exceptionType;
    }

    public Type getType() {
        return exceptionType;
    }
}
