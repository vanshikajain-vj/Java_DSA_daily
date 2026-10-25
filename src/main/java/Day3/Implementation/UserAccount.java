package Day3.Implementation;

import java.util.*;

public final class UserAccount {

    private final UUID id;
    private final Date createdAt;
    private final List<String> roles;

    public UserAccount(UUID id, Date createdAt, List<String> roles) {
        this.id = id;
        this.createdAt = new Date(createdAt.getTime());
        this.roles = new ArrayList<>(roles);
    }

    public UUID getId() {
        return id;
    }

    public Date getCreatedAt() {
        return new Date(createdAt.getTime());
    }

    public List<String> getRoles() {
        return new ArrayList<>(roles);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof UserAccount)) return false;

        UserAccount other = (UserAccount) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}