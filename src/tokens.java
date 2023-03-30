/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author monge
 */
import java.util.*;
import java.util.stream.IntStream;
public class tokens {
  public static void main(String[] args) {
        String[] textos = {
            "Me gusta tomar caguamas y acompañarlas con tostitos morados",
            "me gustan los gatos y tiktoks",
            "quiero mucho a Junior H y a mi perro",
            "ser profundamente amado te da fuerzas, mientras que amar",
            "profundamente a alguien te da coraje",
            "me gustan los carros y las motos",
            "no le entiendo a esta clase",
            "las mañanas son tristes y frias",
            "quiero mucho a mi perrito",
            "la luz dentro de mi dejo de brillar",
            "entre mas sabio mas menos persona",
            "Natanael Canoy Cristiano Ronaldo ejemplos a",
            "seguir, ¿que es la distancia euclidiana?",
            "hoy es un hermoso dia, pero no puedo verlo",
            "no tengo ganas de ir a la escuela, solo quiero dormir todo el dia",
            "ya no quiero salir de mi cama",
            "me gusta programar, ¿que es la tokenizacion?",
            "me mama el four loko y las mamas solteras",
            "me encanta la vida y soy muy feliz"
        };

        List<String> stopWords = new ArrayList<>(Arrays.asList("en", "a","actualmente","adelante","además","afirmó","agregó","ahora","ahí","al","algo","alguna","algunas","alguno","algunos",
              "algún", "alrededor", "ambos", "ampleamos", "ante", "anterior", "antes", "apenas", "aproximadamente", "aquel", "aquellas", "aquellos",
              "aquí", "aquí", "arriba", "aseguró", "así", "atras", "aunque", "ayer", "añadió", "aún", "bajo", "bastante", "bien", "buen", "buena",
              "buenas", "bueno", "buenos", "cada", "casi", "cerca", "cierta", "ciertas", "cierto", "ciertos", "cinco", "comentó", "como", "con",
              "conocer", "conseguimos", "conseguir", "considera", "consideró", "consigo", "consigue", "consiguen", "consigues", "contra", "cosas",
              "creo", "cual", "cuales", "cualquier", "cuando", "cuanto", "cuatro", "cuenta", "cómo", "da", "dado", "dan", "dar", "de", "debe","deben",
              "debido", "decir", "dejó", "del", "demás", "dentro", "desde","después", "dice", "dicen", "dicho", "dieron", "diferente", "diferentes",
              "dijeron", "dijo", "dio", "donde", "dos", "durante", "e", "ejemplo", "el", "ella", "ellas", "ello", "ellos", "embargo", "empleais", "emplean",
              "emplear", "empleas", "empleo", "en", "encima", "encuentra", "entonces", "entre", "era", "erais", "eramos", "eran", "eras", "eres", "es",
              "esa", "esas", "ese", "eso", "esos", "esta", "estaba", "estabais", "estaban", "estabas", "estad", "estada", "estadas", "estado", "estados",
              "estais", "estamos", "estan", "estando", "estar", "estaremos", "estará", "estarán", "estarás", "estaré","estaréis", "estaría", "estaríais",
              "estaríamos", "estarían", "estarías", "estas", "este", "estemos","esto", "estos", "estoy", "estuve", "estuviera", "estuvierais", "estuvieran",
              "estuvieras", "estuvieron", "estuviese", "estuvieseis", "estuviesen", "estuvieses", "estuvimos", "estuviste", "estuvisteis", "estuviéramos",
              "estuviésemos", "estuvo", "está", "estábamos", "estáis", "están", "estás", "esté", "estemos", "esto", "estos", "estoy", "estuve", "estuviera",
              "estuvieran", "estuvieras", "estuvieron", "estuviese", "estuvieseis", "estuviesen", "estuvieses", "estuvimos", "estuviste", "estuvisteis",
              "estuviéramos", "estuviésemos", "estuvo", "está", "estábamos", "estáis", "están", "estás", "esté", "estéis", "estén", "estés", "ex", "existe",
              "existen", "explicó", "expresó", "fin", "fue", "fuera", "fuerais", "fueran", "fueras", "fueron", "fuese", "fueseis", "fuesen", "fueses", "fui",
              "fuimos", "fuiste", "fuisteis", "fuéramos", "fuésemos", "gran", "grandes", "gueno", "ha", "haber", "habida", "habidas", "habido", "habidos", "habiendo",
              "habremos", "habrá", "habrán", "habrás", "habré", "habréis", "habría", "habríais", "habríamos", "habrían", "habrías", "habéis", "había", "habíais", "habíamos",
              "habían", "habías", "hace", "haceis", "hacemos", "hacen", "hacer", "hacerlo", "haces", "hacia", "haciendo", "hago", "han", "has", "hasta", "hay", "haya", "hayamos",
              "hayan", "hayas", "hayáis", "he", "hecho", "hemos", "hicieron", "hizo", "hoy", "hube", "hubiera", "hubierais", "hubieran", "hubieras", "hubieron", "hubiese", "hubieseis",
              "hubiesen", "hubieses", "hubimos", "hubiste", "hubisteis", "hubiéramos", "hubiésemos", "hubo", "igual", "incluso", "indicó", "informó", "intenta", "intentais",
              "intentamos", "intentan", "intentar", "intentas", "intento", "ir", "junto", "la", "lado", "largo", "las", "le", "les", "llegó", "lleva", "llevar", "lo", "los",
              "luego", "lugar", "manera", "manifestó", "mayor", "me", "mediante", "mejor", "mencionó", "menos", "mi", "mientras", "mio", "mis", "misma", "mismas", "mismo",
              "mismos", "modo", "momento", "mucha", "muchas", "mucho", "muchos", "muy", "más", "mí", "mía", "mías", "mío", "míos", "nada", "nadie", "ni", "ninguna", "ningunas",
              "ninguno", "ningunos", "ningún", "no", "nos", "nosotras", "nosotros", "Nuestra", "nuestras", "nuestro", "nuestros", "nueva", "nuevas",
              "nuevo", "nuevos", "nunca", "o", "ocho", "os", "otra", "otras", "otro", "otros", "para", "parece", "parte", "partir", "pasada", "pasado", "pero",
              "pesar", "poca", "pocas", "poco", "pocos", "podeis", "podemos", "poder", "podria", "podriais", "podriamos", "podrian", "podrias", "podrá", "podrán",
              "podría", "podrían", "poner", "por", "por qué", "porque", "posible", "primer", "primera", "primero", "primeros", "principalmente", "propia", "propias",
              "propio", "propios", "próximo", "próximos", "pudo", "pueda", "puede", "pueden", "puedo", "pues", "que", "quedó", "queremos", "quien", "quienes",
              "quiere", "quién", "qué", "realizado", "realizar", "realizó", "respecto", "sabe", "sabeis", "sabemos", "saben", "saber", "sabes", "se", "sea", "seamos",
              "sean", "seas", "segunda", "segundo", "según", "seis", "ser", "seremos", "será", "serán", "serás", "seré", "seréis", "sería", "seríais", "seríamos", "serían",
              "serías", "seáis", "señaló", "si", "sido", "siempre", "siendo", "siete", "sigue", "siguiente", "sin", "sino", "sobre", "sois", "sola", "solamente", "solas",
              "solo", "solos", "somos", "son", "soy", "su", "sus", "suya", "suyas", "suyo", "suyos", "sí", "sólo", "tal", "también", "tampoco", "tan", "tanto", "te",
              "tendremos", "tendrá", "tendrán", "tendrás", "tendré", "tendréis", "tendría", "tendríais", "tendríamos", "tendrían", "tendrías", "tened", "teneis",
              "tenemos", "tener", "tenga", "tengamos", "tengan", "tengas", "tengo", "tengáis", "tenida", "tenidas", "tenido", "tenidos", "teniendo", "tenéis",
              "tenía", "teníais", "teníamos", "tenían", "tenías", "tercera", "ti", "tiempo", "tiene", "tienen", "tienes", "toda", "todas", "todavía", "todo",
              "todos", "total", "trabaja", "trabajais", "trabajamos", "trabajan", "trabajar", "trabajas", "trabajo", "tras", "trata", "través", "tres", "tu",
              "tus", "tuve", "tuviera", "tuvierais", "tuvieran", "tuvieras", "tuvieron", "tuviese", "tuvieseis", "tuviesen", "tuvieses", "tuvimos", "tuviste",
              "tuvisteis", "tuviéramos", "tuviésemos", "tuvo", "tuya", "tuyas", "tuyo", "tuyos", "tú", "ultimo", "un", "una", "unas", "uno", "unos", "usa",
              "usais", "usamos", "usan", "usar", "usas", "uso", "usted", "va", "vais", "valor", "vamos", "van", "varias", "varios", "vaya", "veces", "ver", "verdad",
              "verdadera", "verdadero", "vez", "vosotras","vuestro", "vuestros", "y", "ya", "yo", "él", "éramos", "ésta", "éstas", "éste", "éstos", "última",
              "últimas", "último", "últimos"));

        // Tokenización y filtrado de palabras no relevantes
        List<List<String>> tokenizedCorpus = new ArrayList<>();
        for (String document : textos) {
            String[] words = document.split("\\W+");
            List<String> filteredWords = new ArrayList<>();
            for (String w : words) {
                if (!stopWords.contains(w)) {
                    filteredWords.add(w);
                }
            }
            tokenizedCorpus.add(filteredWords);
        }

        // Creación del vocabulario
        Set<String> vocabulary = new HashSet<>();
        for (List<String> document : tokenizedCorpus) {
            for (String word : document) {
                vocabulary.add(word);
            }
        }

        // Creación de la matriz de representaciones
        double[][] matrix = new double[tokenizedCorpus.size()][vocabulary.size()];
        int i = 0;
        for (List<String> document : tokenizedCorpus) {
            int j = 0;
            for (String word : vocabulary) {
                matrix[i][j] = Collections.frequency(document, word);
                j++;
            }
            i++;
        }

        // Cálculo de la distancia euclidiana entre los textos
        System.out.println("Distancia entre cada texto:");
        for (int k = 0; k < textos.length; k++) {
            for (int l = k + 1; l < textos.length; l++) {
                double distance = EuclideanDistance(matrix, k, l);
                System.out.printf("Distancia entre el texto %d %s y el texto %d %s: %.2f%n", k + 1, textos[k], l + 1, textos[l], distance);
            }
            System.out.println();
        }

        // Cálculo del texto más cercano para cada texto
        System.out.println("Texto más cercano para cada texto:");
        for (int k = 0; k < textos.length; k++) {
            double minDistance = Double.MAX_VALUE;
            int minJ = -1;
            for (int l = 0; l < textos.length; l++) {
                if (k == l) {
                    continue;
                }

                double distance = EuclideanDistance(matrix, k, l);
                if (distance < minDistance) {
                    minDistance = distance;
                    minJ = l;
                }
            }

            System.out.printf("El texto %d %s es más cercano al documento %d %s, con una distancia de %.2f%n", k + 1, textos[k], minJ + 1, textos[minJ], minDistance);
        }
    }

    private static double EuclideanDistance(double[][] matrix, int i, int j) {
        double sum = IntStream.range(0, matrix[i].length)
                .mapToDouble(k -> Math.pow(matrix[i][k] - matrix[j][k], 2))
                .sum();
        return Math.sqrt(sum);
    }
}


