package javacore.Rdatas.test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Map;

public class ZoneTest01 {
    public static void main(String[] args) {

        // Zonas curtas (abreviações)
        Map<String, String> shortIds = ZoneId.SHORT_IDS;
        System.out.println(shortIds);

        // Zona padrão do sistema
        System.out.println(ZoneId.systemDefault());

        // ZONA
        ZoneId tokyoZone = ZoneId.of("Asia/Tokyo");
        System.out.println("Zona: " + tokyoZone);

        // Data e hora SEM zona
        LocalDateTime now = LocalDateTime.now();
        System.out.println("LocalDateTime: " + now);

        // Data e hora COM zona
        ZonedDateTime zonedDateTime = now.atZone(tokyoZone);
        System.out.println("ZonedDateTime: " + zonedDateTime);

        // OFFSET (diferença em relação ao UTC)
        System.out.println("Offset: " + zonedDateTime.getOffset());
    }
}
