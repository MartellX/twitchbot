package constants;

import java.util.*;

public class CommandConstants {
    public static Map<String, String> nicknames = new HashMap<>();
    public static Map<String, List<String>> nicknameVariables = new HashMap<>();
    public static Set<String> botNames = new HashSet<>();
    public static Set<String> blacklist = new HashSet<>();
    public static Set<String> masterNames = new HashSet<>();

    public static void init() {
        nicknames.put("uselessmouth", "UselessMouth");
        nicknameVariables.put("uselessmouth", Arrays.asList(
                "юзя", "uselessmouth", "гений", "ричард", "разгонщик"
        ));

        nicknames.put("mistafaker", "Mistafaker");
        nicknameVariables.put("mistafaker", Arrays.asList(
                "факер", "faker", "fucker", "фхс", "mistafaker", "фейкер", "гном"
        ));

        nicknames.put("melharucos", "Melharucos");
        nicknameVariables.put("melharucos", Arrays.asList(
                "мэл", "мел", "melharucos", "mel", "мельха"
        ));

        nicknames.put("unclebjorn", "UncleBjorn");
        nicknameVariables.put("unclebjorn", Arrays.asList(
                "unclebjorn", "бьерн", "бьёрн", "бьорн", "бурн", "мишка", "медведь", "миха", "михаил"
        ));

        nicknames.put("liz0n", "liz0n");
        nicknameVariables.put("liz0n", Arrays.asList(
                "лиза", "лизон", "пиздон", "liz0n", "elizzavetta", "lison", "lizon"
        ));

        nicknames.put("lasqa", "Lasqa");
        nicknameVariables.put("lasqa", Arrays.asList(
                "ласка", "крыса", "lasqa", "бодя"
        ));

        botNames.add("nightbot");
        botNames.add("moobot");
        botNames.add("streamlabs");
        botNames.add("hepega_bot");

        blacklist.add("педик");
        blacklist.add("пидорас");
        blacklist.add("пидарас");
        blacklist.add("пидар");
        blacklist.add("пидор");
        blacklist.add("пидрила");
        blacklist.add("пидр");
        blacklist.add("пи\\*+с");
        blacklist.add("пи\\*+c");
        blacklist.add("п\\*+р");
        blacklist.add("п\\*+");
        blacklist.add("нигга");
        blacklist.add("нигер");
        blacklist.add("ниггер");
        blacklist.add("негр");
        blacklist.add("неггр");
        blacklist.add("даун");
        blacklist.add("винни-пух");
        blacklist.add("свиней");
        blacklist.add("(https?:\\/\\/)?([\\da-z\\.-]+)\\.([a-z\\.]{2,6})([\\/\\w \\.-]*)*\\/?");
        blacklist.add("@bigrusbot");
        blacklist.add("african");
        blacklist.add("nigger");
        blacklist.add("гитлер");
        blacklist.add("еврей");

        blacklist.add("cemka");
        blacklist.add("taerss");
        blacklist.add("sgtgrafoyni");
        blacklist.add("elwycco");
        blacklist.add("insize");
        blacklist.add("soroket");
        blacklist.add("bacardiy_");
        blacklist.add("alcoreru");
        blacklist.add("beastqt");
        blacklist.add("blackjoker707");
        blacklist.add("cr1m3r".toLowerCase());
        blacklist.add("mooniverse");
        blacklist.add("asmadey");
        blacklist.add("barsart");
        blacklist.add("ren4games");
        blacklist.add("ThePagYYY".toLowerCase());

        masterNames.add("martellx");
//        masterNames.add("pdvrr");
    }

    public static String getNick(String nickVar) {
        for(Map.Entry<String, List<String>> e : nicknameVariables.entrySet()) {
            if (e.getValue().contains(nickVar)) {
                return e.getKey();
            }
        }

        return null;
    }
}
