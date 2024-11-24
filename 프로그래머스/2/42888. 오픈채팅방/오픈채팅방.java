import java.util.*;

class Solution {
    
    static class PreResponse {
        String userId;
        String comment;

        public PreResponse(String userId, String comment) {
            this.userId = userId;
            this.comment = comment;
        }
    }

    static class Command {
        String command;
        String userId;

        public Command(String command, String userId) {
            this.command = command;
            this.userId = userId;
        }
    }
    
    public String[] solution(String[] record){
        Map<String, String> nicknameMap = new HashMap<>();
        Queue<Command> commandQ = new LinkedList<>();

        init(nicknameMap,commandQ,record);

        ArrayList<PreResponse> preResponseList = getPreResponseList(commandQ);

        String[] answer = getResult(preResponseList, nicknameMap);
        return answer;
    }
    private static void init( Map<String, String> nicknameMap,Queue<Command> commandQ,String[] record){
        for (String string : record) {
            StringTokenizer st = new StringTokenizer(string);
            String command = st.nextToken();
            String userId = st.nextToken();
            commandQ.add(new Command(command,userId));

            if(command.equals("Leave")) continue;

            String nickname = st.nextToken();
            if(nicknameMap.containsKey(userId)){
                nicknameMap.replace(userId,nickname);
            }else{
                nicknameMap.put(userId,nickname);
            }
        }
    }

    private static String[] getResult(ArrayList<PreResponse> preResponseList, Map<String, String> nicknameMap) {
        String[] answer = new String[preResponseList.size()];
        int index =0;
        for(PreResponse preResponse : preResponseList){
            String nickname = nicknameMap.get(preResponse.userId);
            String comment = preResponse.comment;
            answer[index++] = nickname+comment;
        }
        return answer;
    }

    private static ArrayList<PreResponse> getPreResponseList(Queue<Command> commandQ) {
        ArrayList<PreResponse> preResponseList = new ArrayList<>();
        while (!commandQ.isEmpty()) {
            Command poll = commandQ.poll();
            String command = poll.command;
            String comment = "";
            String userId = poll.userId;

            if (command.equals("Enter")) {
                comment = "님이 들어왔습니다.";
            }
            if (command.equals("Leave")) {
                comment = "님이 나갔습니다.";
            }
            if (command.equals("Change")) {
               continue;
            }
            preResponseList.add(new PreResponse(userId,comment));
        }
        return preResponseList;
    }
}