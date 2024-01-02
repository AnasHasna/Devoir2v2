package org.example.model;

public class RePost extends SimplePost {
    private User subPostAuthor;
    private Post subPost;

    public RePost(String text, User subPostAuthor, Post subPost) {
        super(text);
        this.subPostAuthor = subPostAuthor;
        this.subPost = subPost;
    }

    @Override
    public String getText() {
        // Combine the text of the new post, subPostAuthor, and the text of the shared post
        return super.getText() + "\nShared by: " + subPostAuthor.getName() + "\n" + subPost.getText();
    }

    public User getSubPostAuthor() {
        return subPostAuthor;
    }

    public Post getSubPost() {
        return subPost;
    }
}

