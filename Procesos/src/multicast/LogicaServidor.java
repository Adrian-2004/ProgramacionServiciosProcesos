package multicast;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LogicaServidor {

    public static String obtenerHoraLocal(LocalDate fecha) {
        LocalTime horaActual = LocalTime.now();

        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yy");
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");

        return "Fecha: " + fecha.format(formatoFecha) + ", Hora actual: " + horaActual.format(formatoHora);
    }
}