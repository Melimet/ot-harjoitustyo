package domain;

import org.junit.*;

import java.util.ArrayList;

import static junit.framework.TestCase.assertNotNull;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class TowerTest {

    private Tower tower;
    private Invader invader;
    private Map map;

    @Before
    public void setUp() {
        this.map = new Map("hello_world2.txt");
        this.tower = new Tower(0, 3, 1, 5.0, 1, 5, 2);
        ArrayList<int[]> startingCoordinates = new ArrayList<>();
        startingCoordinates.add(new int[]{5, 4});
        this.invader = new Invader(3, 3, startingCoordinates);
    }

    @Test
    public void getY() {
        assertThat(this.tower.getY(), is(2.0));
    }

    @Test
    public void getX() {
        assertThat(this.tower.getX(), is(5.0));
    }

    @Test
    public void towerAttacksIfInRange() {
        assertThat(this.tower.isInAttackRange(invader), is(true));
    }

    @Test
    public void towerDoesntAttackIfNotInRange() {
        Tower tower2 = new Tower(1, 3, 1, 1.0, 1, 5, 2);
        assertThat(tower2.isInAttackRange(invader), is(false));
    }

    @Test
    public void attackingReducesInvaderHp() {
        //assertThat(this.tower.attackInvader(invader),is(0));
        //TODO Update this when attackInvader method progresses
    }

    @Test
    public void convertingXAndYWorksAsIntended() {
        this.tower.convertXY(92, 92);
        assertThat(this.tower.getX(), is(1.0));
        assertThat(this.tower.getY(), is(1.0));
        assertThat(this.tower.getPixelX(), is(92.0));
        assertThat(this.tower.getPixelY(), is(137.0));

    }
}
