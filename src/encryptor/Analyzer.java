package encryptor;

import java.util.*;

public interface Analyzer {



    LettersPack getLettersPack();

    default Map<Character, Integer> doLettersMap(String text){
        Map<Character, Integer> map = new HashMap<>();
        String textLowerCase = text.toLowerCase();
        int count = 0;

        char letter = getLettersPack().getFirstLetter();
        for (int i = 0; i < getLettersPack().getLettersAmount(); i++) {
            for (int j = 0; j < text.length(); j++) {
                if(letter == textLowerCase.charAt(j)){
                    count++;
                }
            }
            map.put(letter, count);
            if(letter <= getLettersPack().getLastLetter()){letter ++;}
            count = 0;
        }
        return map;
    }

    default int getKey(String textToDecrypt, String instanceForAnalysis){

        Map<Character, Integer> map = doLettersMap(textToDecrypt);
        Map<Character, Integer> map1 = doLettersMap(instanceForAnalysis);

        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> listSum = new ArrayList<>();

        int[] indexes = new int[map.size()];

        int key;
        int sum;
        int index = 0;
        int min;

        for (char i = getLettersPack().getFirstLetter(); i <= getLettersPack().getLastLetter(); i++) {
            list.add(map.get(i));
            list1.add(map1.get(i));
        }

        for (int i = 0; i < map.size(); i++) {
            for (int j = 0; j < map.size(); j++) {

                index = index + list.get(j) - list1.get(j);
                indexes[j] = Math.abs(index);
            }
            sum = Arrays.stream(indexes).sum();

            index = 0;
            listSum.add(sum);
            Collections.rotate(list, 1);
        }

        min = Collections.min(listSum);
        key = listSum.indexOf(min);



        return getLettersPack().getLettersAmount() - key;
    }

}
