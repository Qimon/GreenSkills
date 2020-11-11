package fr.sber.greenskills.logger;

import java.io.Serializable;
import java.util.Date;

public class Logger implements Serializable {

    public Date date;
    public String level;
    public String message;

    public Logger(Date date, String level, String message) {
        this.date = date;
        this.level = level;
        this.message = message;
    }

    public Logger() {
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Logger{" +
                "date=" + date +
                ", level='" + level + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
