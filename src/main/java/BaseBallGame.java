public class BaseBallGame {

    public static void main(String []args) {
        BaseBallGame newGame = new BaseBallGame();
        BaseBallDTO dto = new BaseBallDTO();
        EnemyNumberGenerator generator = new EnemyNumberGenerator();
        generator.setEnemyNumber(generator.generateNumber(dto));
    }

}