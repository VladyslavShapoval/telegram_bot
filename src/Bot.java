import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {
private long chatId;
    @Override
    public void onUpdateReceived(Update update) {
        update.getUpdateId();
        SendMessage sendMessage = new SendMessage().setChatId(update.getMessage().getChatId());
        chatId= update.getMessage().getChatId();

            sendMessage.setText(input(update.getMessage().getText()));
            try{
                execute(sendMessage);
            }
            catch (TelegramApiException e){
                e.printStackTrace();
            }
        }


    @Override
    public String getBotUsername() {
        return "UT61_bot";
    }

    @Override
    public String getBotToken() {
        return "862980204:AAGKzb5pY6xlPjpd8pbZoCwNlaQ6nHlGE8s";
    }
    public String input(String msg){
        if(msg.contains("Понедельник") || msg.contains("понедельник")){
            return "Выходной";
        }
        else if (msg.contains("Вторник") || msg.contains("вторник")){
            return "15:20 - Перекладацька практика (Шевченко І.С) \n" +
                    "17:00 - Теорія та практика перекладу (Ільченко В.В)";
        }
        else if (msg.contains("Среда") || msg.contains("среда")){
            return
                    "15:20 - Управління проектами в туризмі (Довгаль Г.В). \n" +
                    "17:00 - Управління проектами в туризмі (Довгаль Г.В).";
        }
        else if (msg.contains("Четверг")|| msg.contains("четверг")){
            return "15:20 - Іноземна мова за проф. спрямуваннм (Ільченко В.В)\n" +
                    "17:00 - Іноземна мова за проф. спрямуваннм (Ільченко В.В)\n" +
                    "18:40 - Кон'юнктура туристичного ринку (Євтушенко О.В)";
        }
        else if (msg.contains("Пятница")|| msg.contains("пятница")){
            return "13:40 - Туристична політика зарубіжних країн (Шамара І.М)\n" +
                    "15:20 - Туристична політика зарубіжних країн (Шамара І.М) \n" +
                    "17:00 - Теорія та практика перекладу (Ільченко В.В)";
        }
        else if (msg.contains("Суббота")|| msg.contains("суббота")){
           return "Все хорошо, можно отдохнуть";
        }
        else if (msg.contains("Воскресенье")|| msg.contains("воскресенье")){
            return "Сегодня еще воскресенье";
        }
        else{ return "Введите день недели";}
    }


}
