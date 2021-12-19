package com.smdsa.madmeditation.retro;

public class login {

    private String id;

    private String email;

    private String nickName;

    private String avatar;

    private String token;

    public login(){

    }

    public login(String id, String email, String nickName, String avatar, String token) {
        this.id = id;
        this.email = email;
        this.nickName = nickName;
        this.avatar = avatar;
        this.token = token;
    }

    public void setId(String id){
        this.id = id;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setNickName(String nickName){
        this.nickName = nickName;
    }

    public void setAvatar(String avatar){
        this.avatar = avatar;
    }

    public void setToken(String token){
        this.token = token;
    }

    public String getId() {
        return this.id;
    }

    public String getEmail() {
        return this.email;
    }

    public String getNickName() {
        return this.nickName;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getToken() {
        return this.token;
    }

}
