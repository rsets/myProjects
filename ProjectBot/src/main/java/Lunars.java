import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lunars {

    Map<String, String> monthNames;

    List<ArrayList> Lunars;

    String[] LunarsNames;

    Map<String, String> map;

    ArrayList<String> oven;
    ArrayList<String> telec;
    ArrayList<String> blizneci;
    ArrayList<String> rak;
    ArrayList<String> lev;
    ArrayList<String> deva;
    ArrayList<String> vesi;
    ArrayList<String> scorpion;
    ArrayList<String> strelec;
    ArrayList<String> kozerog;
    ArrayList<String> vodoley;
    ArrayList<String> ribi;


    public Lunars() {
        LunarsNames = new String[]{"Овен", "Телец", "Близнецы", "Рак", "Лев",
                "Дева", "Весы", "Скорпион", "Стрелец", "Козерог", "Водолей", "Рыба"};
        map = new HashMap<>();
        Lunars = new ArrayList<ArrayList>(12);
        oven = new ArrayList<>();
        telec = new ArrayList<>();
        blizneci = new ArrayList<>();
        rak = new ArrayList<>();
        lev = new ArrayList<>();
        deva = new ArrayList<>();
        vesi = new ArrayList<>();
        scorpion = new ArrayList<>();
        strelec = new ArrayList<>();
        kozerog = new ArrayList<>();
        vodoley = new ArrayList<>();
        ribi = new ArrayList<>();
        monthNames = new HashMap<>();
        monthNames.put("01", "января");
        monthNames.put("02", "февраля");
        monthNames.put("03", "марта");
        monthNames.put("04", "апреля");
        monthNames.put("05", "мая");
        monthNames.put("06", "июня");
        monthNames.put("07", "июля");
        monthNames.put("08", "августа");
        monthNames.put("09", "сентября");
        monthNames.put("10", "октября");
        monthNames.put("11", "ноября");
        monthNames.put("12", "декабря");

        Lunars.add(oven);
        Lunars.add(telec);
        Lunars.add(blizneci);
        Lunars.add(rak);
        Lunars.add(lev);
        Lunars.add(deva);
        Lunars.add(vesi);
        Lunars.add(scorpion);
        Lunars.add(strelec);
        Lunars.add(kozerog);
        Lunars.add(vodoley);
        Lunars.add(ribi);

        map.put("Овен", "aries");
        map.put("Телец", "taurus");
        map.put("Близнецы", "gemini");
        map.put("Рак", "cancer");
        map.put("Лев", "leo");
        map.put("Дева", "virgo");
        map.put("Весы", "libra");
        map.put("Скорпион", "scorpio");
        map.put("Стрелец", "sagittarius");
        map.put("Козерог", "capricorn");
        map.put("Водолей", "aquarius");
        map.put("Рыба", "pisces");

        add();
    }

    public String getTextByDate(String date) {
        String key = getNameLunarByDate(date);
        String text = "";
        try {
            String lunarInEng = map.get(key);
            if (lunarInEng != null) {
                text += Text.getTextByLunar(lunarInEng);
            } else {
                text += "Чтобы получить гороскоп, введите правильно дату";
            }

        } catch (Exception e) {
            text += "Чтобы получить гороскоп, введите правильно дату";
        }
        return text;
    }

    public String getNameLunarByDate(String date) {
        int numLunar = 999;
        for (int i = 0; i < Lunars.size(); i++) {
            if (Lunars.get(i).contains(date)) {
                numLunar = i;
            }
        }
        String result;
        try {
            result = LunarsNames[numLunar];
        } catch (Exception ex) {
            result = "Введите месяц в формате: 22.12";
        }
        return result;
    }


    private void add() {
        Adder(oven, 21, 31, 3);
        Adder(oven, 1, 20, 4);
        Adder(telec, 21, 30, 4);
        Adder(telec, 1, 21, 5);
        Adder(blizneci, 22, 31, 5);
        Adder(blizneci, 1, 21, 6);
        Adder(rak, 22, 30, 6);
        Adder(rak, 1, 22, 7);
        Adder(lev, 23, 31, 7);
        Adder(lev, 1, 21, 8);
        Adder(deva, 22, 31, 8);
        Adder(deva, 1, 23, 9);
        Adder(vesi, 24, 30, 9);
        Adder(vesi, 1, 23, 10);
        Adder(scorpion, 24, 31, 10);
        Adder(scorpion, 1, 22, 11);
        Adder(strelec, 23, 30, 11);
        Adder(strelec, 1, 22, 12);
        Adder(kozerog, 23, 31, 12);
        Adder(kozerog, 1, 20, 1);
        Adder(vodoley, 21, 31, 1);
        Adder(vodoley, 1, 19, 2);
        Adder(ribi, 20, 29, 2);
        Adder(ribi, 1, 20, 3);
    }

    private void Adder(List list, int startDay, int endDay, int month) {
        String monthString = "";
        if (month < 10) {
            monthString += "0";
            monthString += String.valueOf(month);
        } else {
            monthString += String.valueOf(month);
        }
        for (int i = startDay; i <= endDay; i++) {
            String dayString = "";
            if (i < 9) {
                dayString += "0";
                dayString += String.valueOf(i);
            } else {
                dayString += String.valueOf(i);
            }
            list.add(dayString + "." + monthString);
            list.add(dayString + " " + monthNames.get(monthString));
        }
    }
}