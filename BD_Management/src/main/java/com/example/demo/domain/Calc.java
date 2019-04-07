package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

// ▼ @EntityをつけることでDBのテーブルと紐づく
@Entity
public class Calc {

	// ▼ @Idを付けた変数がテーブルのプライマーキーになる
	// ▼ @GeneratedValueをつけると連番が自動で振られるようになる

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty				// @NotEmptyをつけるとnullと空文字を許容しなくなる
    @Size(max=20)			// @Sizeで文字数制限
    private String name;

    @NotNull				// @NotNullをつけるとnullを許容しなくなる
    @Min(value=-99)
    @Max(value=99)
    private Integer year;

    @NotNull				// @NotNullをつけるとnullを許容しなくなる
    @Min(value=-99)
    @Max(value=99)
    private Integer month;

    @NotNull				// @NotNullをつけるとnullを許容しなくなる
    @Min(value=-99)
    @Max(value=99)
    private Integer date;

    @NotNull				// @NotNullをつけるとnullを許容しなくなる
    @Min(value=-99)
    @Max(value=99)
    private Integer hour;

    @NotNull				// @NotNullをつけるとnullを許容しなくなる
    @Min(value=-99)
    @Max(value=99)
    private Integer minutes;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getYear() {
        return year;
    }
    public void setYear(Integer year) {
        this.year = year;
    }
    public Integer getMonth() {
        return month;
    }
    public void setMonth(Integer month) {
        this.month = month;
    }
    public Integer getDate() {
        return date;
    }
    public void setDate(Integer date) {
        this.date = date;
    }

    public Integer getHour() {
        return hour;
    }
    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public Integer getMinutes() {
        return minutes;
    }
    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    @Override
    public String toString() {
        return "calc [id=" + id + ", name=" + name + ", year=" + year + ", month=" + month + ", date=" + date + ", hour=\" + hour + \", minutes=\" + minutes + \"]";
    }
}