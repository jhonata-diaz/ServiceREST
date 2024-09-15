package com.ucb.FramkyService;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    @Value("${greetOficial}")
    private String greet;

    String Nombre;
   // String greet = "Preguntate si lo que estas haciendo hoy te acerca al lugar en el que quieres estar mañana";

    String mensajeNuevoConNombre;
    public GreetingService(){

    }

    public String getGreeting() {
        return greet;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public void setMensajeNuevoConNombre(String mensajeNuevoConNombre) {
        this.mensajeNuevoConNombre = mensajeNuevoConNombre+" "+getGreeting();
    }

    public GreetingService MensajeConNombre(String Nombre) {

        this.Nombre = Nombre;
        setMensajeNuevoConNombre(Nombre);
        return this;

    }

    public String getMensajeNuevoConNombre() {
        return mensajeNuevoConNombre;
    }

    public static void main(String[] args) {

        GreetingService greetingService = new GreetingService();
        greetingService.MensajeConNombre("jhonatan");

        System.out.println(greetingService.getMensajeNuevoConNombre());
    }


    public String translateText(String languageCode) {
        switch (languageCode.toLowerCase()) {
            case "en": // Inglés
                return "Ask yourself if what you are doing today is bringing you closer to where you want to be tomorrow";
            case "fr": // Francés
                return "Demandez-vous si ce que vous faites aujourd'hui vous rapproche de l'endroit où vous voulez être demain";
            case "de": // Alemán
                return "Fragen Sie sich, ob das, was Sie heute tun, Sie näher an den Ort bringt, an dem Sie morgen sein möchten";
            case "it": // Italiano
                return "Chiediti se ciò che stai facendo oggi ti sta avvicinando al luogo in cui desideri essere domani";
            case "pt": // Portugués
                return "Pergunte-se se o que você está fazendo hoje está te aproximando de onde você quer estar amanhã";
            case "zh": // Chino
                return "问问自己，今天所做的事情是否使你更接近明天想去的地方";
            case "ru": // Ruso
                return "Задайте себе вопрос, приближает ли вас то, что вы делаете сегодня, к тому месту, где вы хотите быть завтра";
            case "ja": // Japonés
                return "今日していることが、明日自分がいたい場所に近づいているかどうか、自問してみてください";
            case "ar": // Árabe
                return "اسأل نفسك إذا كان ما تفعله اليوم يقربك من المكان الذي تريد أن تكون فيه غدًا";
            case "es": // Español
            default:
                return "Pregúntate si lo que estás haciendo hoy te acerca al lugar en el que quieres estar mañana";

        }
    }

}


