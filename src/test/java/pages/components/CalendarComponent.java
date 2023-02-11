package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CalendarComponent {
    public void setDate(String day, String month, String year) {
        $$(".react-datepicker__month-select option").findBy(text(month)).click();
        $$(".react-datepicker__year-select option").findBy(text(year)).click();
        $(".react-datepicker__day--0" + day).click();
    }
}
