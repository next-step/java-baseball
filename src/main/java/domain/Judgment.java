package domain;

public enum Judgment {
    STRIKE {
        @Override
        public void compare(Ball catcher, Ball player, int i) {
            if(catcher.balls.get(i).equals(player.balls.get(i))){
                count++;
            }
        }
    },
    BALL {
        @Override
        public void compare(Ball catcher, Ball player, int i) {
            if(catcher.balls.contains(player.balls.get(i)) && !catcher.balls.get(i).equals(player.balls.get(i))){
                count++;
            }
        }
    },
    NOTHING {
        @Override
        public void compare(Ball catcher, Ball player, int i) {
            if(!catcher.balls.contains(player.balls.get(i))){
                count++;
            }
        }

    };

    public int count;
    public abstract void compare(Ball catcher, Ball player, int i);

    public int getCount(Ball catcher, Ball player){
        count = 0;

        for(int i=0; i<catcher.balls.size(); i++){
            compare(catcher, player, i);
        }
        return count;
    }

    public static Boolean judge(Ball catcherBall, Ball playerBall) {
        STRIKE.getCount(catcherBall, playerBall);
        BALL.getCount(catcherBall, playerBall);
        NOTHING.getCount(catcherBall, playerBall);
        printCount();

        return STRIKE.count == 3;
    }

    private static void printCount(){
        if(NOTHING.count == 3){
            System.out.print("낫싱");
        }
        System.out.println((STRIKE.count!=0?STRIKE.count + "스트라이크 ":"") + (BALL.count!=0?BALL.count + "볼 ":""));
    }
}