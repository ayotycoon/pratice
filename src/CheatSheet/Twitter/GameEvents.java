//package CheatSheet.Twitter;
//
//
//import java.util.*;
//
//class Score{
//    int actualTime;
//    String timeString;
//    String teamName;
//    String playerName;
//    String substituteName;
//    char eventType;
//    boolean isFirstHalf;
//    public Score(int actualTime, String timeString, String teamName,String playerName,String substituteName,char eventType, boolean isFirstHalf){
//        this.actualTime = actualTime;
//        this.timeString = timeString;
//        this.teamName = teamName;
//        this.playerName = playerName;
//        this.substituteName = substituteName;
//        this.eventType = eventType;
//        this.isFirstHalf = isFirstHalf;
//    }
//    public String toString(){
//        return  actualTime  + " " + timeString + "  " + teamName + "  " + playerName +" " +  substituteName + " "+ eventType +
//                " " + isFirstHalf;
//    }
//    public String getOutputString(){
//        return this.teamName +" " + this.playerName + " " + this.timeString + " " + this.eventType + " " + this.substituteName;
//    }
//}
//
//
//public class GameEvents {
//
//    static Map<Character, Integer> map = new HashMap<>();
//    public static List<String> getEventsOrder(String team1, String team2, List<String> events1, List<String> events2) {
//        map.put('G', 1);
//        map.put('Y', 2);
//        map.put('R', 3);
//        map.put('S', 4);
//        List<Score> scores = new ArrayList<>();
//        for(String e1: events1){
//            Score score = parseString(e1, team1);
//            scores.add(score);
//
//        }
//        for(String e2: events2){
//            Score score = parseString(e2, team2);
//            scores.add(score);
//
//        }
//        Collections.sort(scores, new Comparator<Score>(){
//            public int compare(Score s1, Score s2){
//                if(s1.isFirstHalf== true && s2.isFirstHalf==false){
//                    return -1;
//                }
//                if(s1.isFirstHalf== false && s2.isFirstHalf==true){
//                    return 1;
//                }
//                if(s1.actualTime != s2.actualTime)
//                    return s1.actualTime -  s2.actualTime;
//                if(map.get(s1.eventType)!= map.get(s2.eventType)){
//                    return map.get(s1.eventType)- map.get(s2.eventType);
//                }
//                if(!s1.teamName.equals(s2.teamName))
//                    return s1.teamName.compareTo(s2.teamName);
//                return s1.playerName.compareTo(s2.playerName);
//            }
//        });
//        List<String> answer = new ArrayList<>();
//        for(Score score: scores){
//            answer.add(score.getOutputString().trim());
//        }
//        return answer;
//
//    }
//    public static Score parseString(String str, String team){
//        String[] words = str.split(" ");
//        int time = getTimeIndex(words);
//        char event = words[time+1].charAt(0);
//        String player = "";
//        for(int i=0;i<time;i++){
//            player  = player + " " + words[i];
//        }
//        player = player.trim();
//        String sub = "";
//        if(event=='S'){
//            for(int i =time+2;i<words.length;i++){
//                sub += words[i] + " ";
//            }
//            sub = sub.trim();
//        }
//        int actualTime =0;
//        boolean isFirstHalf = false;
//        if(words[time].contains("+")){
//           // System.out.println(words[time]);
//            String timeSplit[] = words[time].split("\\+");
//            actualTime += Integer.parseInt(timeSplit[0]);
//            if(actualTime <= 45){
//                isFirstHalf = true;
//            }
//            actualTime += Integer.parseInt(timeSplit[1]);
//        }else{
//            actualTime += Integer.parseInt(words[time]);
//            if(actualTime <= 45){
//                isFirstHalf = true;
//            }
//        }
//        Score score = new Score(actualTime, words[time], team, player,  sub, event, isFirstHalf);
//        return score;
//    }
//    public static int getTimeIndex(String[] words){
//        for(int i =0;i<words.length;i++){
//            if(words[i].charAt(0)>='0' && words[i].charAt(0)<='9'){
//                return i;
//            }
//        }
//        return -1;
//    }
//
//
//
//    public static void main(String[] args) {
//        String team1 = "EDC";
//        String team2 = "CDE";
//        List<String> events1 = new ArrayList<>(){{add("EDC FirstName LastName 43 Y");}};
//        List<String> events2 = new ArrayList<>(){{add("CDE Name 3 45+1 S SubName");add("CDE Name4 46 G");}};;
//    var ans = getEventsOrder( team1,  team2, events1,  events2);
//System.out.println(ans);
//
//    }
//}
//
//
//
//    static Map<Integer, Node> graph = new HashMap<>();
//static class Node {
//    int rank;
//    Node parent;
//    Node() {
//        rank = 0;
//        parent = this;
//    }
//}
//
//    private static Node findParent(Node node) {
//        if (node == node.parent) return node;
//        node.parent = findParent(node.parent);
//        return node.parent;
//    }
//
//    private static void union(Node node1, Node node2) {
//        Node p1 = findParent(node1);
//        Node p2 = findParent(node2);
//
//        if (p1 == p2) return;
//        if (p1.rank >= p2.rank) {
//            p2.parent = p1;
//            p1.rank += 1;
//        } else {
//            p1.parent = p2;
//            p2.rank += 1;
//        }
//    }
//
//    public static int countGroups(List<String> related) {
//        for(int i = 0; i < related.size(); i++) {
//            graph.put(i, new Node());
//        }
//
//        for(int i = 0; i < related.size(); i++) {
//            for(int j = i+1; j < related.size(); j++) {
//                if (related.get(i).charAt(j) == '1') {
//                    union(graph.get(i), graph.get(j));
//                }
//            }
//        }
//        Set<Node> set = new HashSet<>();
//        for(int i = 0; i < related.size(); i++) {
//            set.add(findParent(graph.get(i)));
//        }
//        return set.size();
//    }
