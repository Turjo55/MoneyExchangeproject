package com.example.group57moneyexchangeproject;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Workshop {
    private final StringProperty name;
    private final StringProperty code;
    private final StringProperty title;
    private final StringProperty date;
    private final StringProperty start;
    private final StringProperty end;

    public Workshop(String name, String code, String title, String date, String start, String end) {
        this.name = new SimpleStringProperty(name);
        this.code = new SimpleStringProperty(code);
        this.title = new SimpleStringProperty(title);
        this.date = new SimpleStringProperty(date);
        this.start = new SimpleStringProperty(start);
        this.end = new SimpleStringProperty(end);
    }

    public StringProperty nameProperty() { return name; }
    public StringProperty codeProperty() { return code; }
    public StringProperty titleProperty() { return title; }
    public StringProperty dateProperty() { return date; }
    public StringProperty startProperty() { return start; }
    public StringProperty endProperty() { return end; }

    public String getName() { return name.get(); }
    public String getCode() { return code.get(); }
    public String getTitle() { return title.get(); }
    public String getDate() { return date.get(); }
    public String getStart() { return start.get(); }
    public String getEnd() { return end.get(); }

    public void setName(String name) { this.name.set(name); }
    public void setCode(String code) { this.code.set(code); }
    public void setTitle(String title) { this.title.set(title); }
    public void setDate(String date) { this.date.set(date); }
    public void setStart(String start) { this.start.set(start); }
    public void setEnd(String end) { this.end.set(end); }
}
