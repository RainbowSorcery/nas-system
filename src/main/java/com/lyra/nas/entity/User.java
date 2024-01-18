package com.lyra.nas.entity;


import com.lyra.nas.config.JpaIdConfig;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.GenericGenerator;

@Entity(name = "user")
public class User {
    @Id
    @Schema(description = "主键")
    @GeneratedValue(generator = "snowFake")
    @GenericGenerator(name = "snowFake", type = JpaIdConfig.class)
    private Long id;
    @Schema(description = "用户名")
    @NotNull(message = "用户名不能为空")
    private String username;
    @Schema(description = "密码")
    @NotNull(message = "密码不能为空")
    private String password;
    @Schema(description = "性别 0: 男 1: 女")
    @NotNull(message = "性别不能为空")
    private String gender;
    @Schema(description = "用户状态 0: 正常 1: 禁用")
    private Integer type;


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", type=" + type +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
