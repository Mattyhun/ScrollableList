package com.example.videolist;


public class Video {

    private final String avatarURL;
    private final String description;
    private final String email;
    private final String title;
    private final String userName;
    private final String created;


    public Video(String avatarURL, String description, String email, String title, String userName, String created) {
        this.avatarURL = avatarURL;
        this.description = description;
        this.email = email;
        this.title = title;
        this.userName = userName;
        this.created = created;
    }

    public String getAvatarURL() {
        return avatarURL;
    }

    public String getDescription() {
        return description;
    }

    public String getEmail() {
        return email;
    }

    public String getTitle() {
        return title;
    }

    public String getUserName() {
        return userName;
    }

    public String getCreated() {
        return created;
    }

}
