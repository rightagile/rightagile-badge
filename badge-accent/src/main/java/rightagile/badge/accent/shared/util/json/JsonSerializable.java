package rightagile.badge.accent.shared.util.json;

public interface JsonSerializable {
    default String toJson() {
        return JsonUtil.toJson(this);
    }
}