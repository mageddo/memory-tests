package eu.kielczewski.example.domain;

import com.google.common.base.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class User {


    @NotNull
    @Size(max = 11)
    private String id;

    @NotNull
    @Size(max = 64)
    private String password;

    private User() {
    }

    public User(final String id, final String password) {
        this.id = id;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
          .add("id", id)
          .add("password", password)
          .toString();
    }
}
