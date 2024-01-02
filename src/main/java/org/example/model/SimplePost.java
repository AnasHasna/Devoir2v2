package org.example.model;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

public class SimplePost implements Post {
    private Instant date;
    private String text;
    private List<User> likers;

    public SimplePost(String text) {
        this.date = Instant.now();
        this.text = text;
        this.likers = new ArrayList<>();
    }

    @Override
    public Instant getDate() {
        return date;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public int getLikeNumber() {
        return likers.size();
    }

    @Override
    public boolean hasLikeFrom(User u) {
        return likers.contains(u);
    }

    @Override
    public boolean addLikeFrom(User u) {
        return likers.add(u);
    }

    @Override
    public Set<User> getLikers() {
        return Set.copyOf(likers); // Convert List to Set
    }

    @Override
    public ListIterator<User> iterator() {
        return likers.listIterator();
    }

    @Override
    public int compareTo(Post p) {
        return date.compareTo(p.getDate());
    }

    @Override
    public boolean isBefore(Post p) {
        return date.isBefore(p.getDate());
    }

    @Override
    public boolean isAfter(Post p) {
        return date.isAfter(p.getDate());
    }
}

