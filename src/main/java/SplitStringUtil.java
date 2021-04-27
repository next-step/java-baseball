import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


class SplitStringUtil {
    List<Integer> splitDigitNumber(String targetNumberStr){
        List<Integer> resultList = null;

        if(targetNumberStr == null || targetNumberStr.isEmpty() == true){
            return null;
        } else {
            try {
                Integer changeNumber = null;
                resultList = new ArrayList<>();


                if(targetNumberStr.contains(",") == true){
                    String[] strNumbers = targetNumberStr.split(",");

                    for(String numberStr : strNumbers) {
                        if (numberStr != null && numberStr.isEmpty() == false){
                            changeNumber = Integer.parseInt(numberStr);
                            resultList.add(changeNumber);
                        }
                    }
                } else {
                    changeNumber = Integer.parseInt(targetNumberStr);
                    resultList.add(changeNumber);
                }

            } catch (Exception e){
                return null;
            }
        }

        return resultList;
    }

    String subStringText(String targetNumberStr){
        String resultStr = "";

        if(targetNumberStr == null || targetNumberStr.isEmpty() == true){
            return null;
        } else {
            try {
                int foundIdx = 0, strIdx=0, endIdx=0;
                String patternRegex = "((\\d)(,|\\d)*)", inputFncStr = null;
                Pattern pattern = Pattern.compile(patternRegex);
                Matcher matcher = pattern.matcher(targetNumberStr);
                inputFncStr = "";

                while (matcher.find() == true) {
                    strIdx = matcher.start();
                    endIdx = matcher.end();
                    resultStr += targetNumberStr.substring(strIdx, endIdx);
                }
            } catch (Exception e){
                return null;
            }
        }

        return resultStr;
    }

    char getCharLocation(String targetWord, int findCharIndex){
        char resultChar = ' ';

        if(targetWord == null || targetWord.isEmpty() == true ){
            return resultChar;
        } else {
            resultChar = targetWord.charAt(findCharIndex);
        }
        return resultChar;
    }

}
