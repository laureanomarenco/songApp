package com.songFormatter.entidades;

public class Usuario {
    private Integer idUsuario;
    private String nickname;
    private String img;
    private String password;
    private String mail;

    public Usuario() {

    }

    public Usuario(Integer idUsuario, String nickname, String img, String password, String mail) {
        this.idUsuario = idUsuario;
        this.nickname = nickname;
        this.img = img;
        this.password = password;
        this.mail = mail;
    }

    public Usuario(String nickname, String img, String password, String mail) {
        this.nickname = nickname;
        this.img = img;
        this.password = password;
        this.mail = mail;
    }

    public int getId() {
        return idUsuario;
    }

    public void setId(Integer id) {
        this.idUsuario = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", nickname='" + nickname + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
