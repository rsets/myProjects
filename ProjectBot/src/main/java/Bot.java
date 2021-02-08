import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.send.SendPhoto;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.User;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.io.File;

public class Bot extends TelegramLongPollingBot {

    Lunars lunars = new Lunars();

    // Метод который ловит сообщения
    // он срабатывает только тогда когда полует сообщение от пользователя
    public void onUpdateReceived(Update update) {

        User userName = update.getMessage().getFrom();
        String text = update.getMessage().getText();
        String chatId = update.getMessage().getChatId().toString();
        System.out.println(text + " <== message from " + userName.getFirstName() + " (" + userName.getUserName() + ")");

        if (text.equalsIgnoreCase("/start")) {
            sendMsg(chatId, "Для работы бота, Вы должны написать свою дату рождения в одном из видов : \"22.12\" или \"22 декабря\" ");
        } else {
            String lunar = lunars.getNameLunarByDate(text);
            sendMsg(chatId, lunar);
            sendPhoto(chatId, lunar + ".gif");
            sendMsg(chatId, lunars.getTextByDate(text));
        }
    }

    public synchronized void sendPhoto(String chatId, String photoName) {
        SendPhoto sendPhoto = new SendPhoto();
        try {
            File file = new File("pictures/" + photoName);
            sendPhoto.setChatId(chatId);
            sendPhoto.setNewPhoto(file);
            sendPhoto(sendPhoto);
        } catch (Exception e) {
            System.out.println("Error send Photo");
        }
    }

    // Метод отправляет сообщения
    public synchronized void sendMsg(String chatId, String s) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText(s);
        try {
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
            System.out.println("ERROR");
        }
    }

    public String getBotUsername() {
        return "Lunar_testbot";
    }

    @Override
    public String getBotToken() {
        return "you will not use my bot for selling drugs";
    }

    public static void main(String[] args) {
        ApiContextInitializer.init();

        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            Bot b = new Bot();
            telegramBotsApi.registerBot(b);
            System.out.println("Bot started");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
