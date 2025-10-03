import java.util.*;

//Starategy Interface for walk
interface WalkableRobot {
    void walk();
}

class NormalWalk implements WalkableRobot {
    @Override
    public void walk() {
        System.out.println("Walking normally");
    }
}

class NoWalk implements WalkableRobot {
    @Override
    public void walk() {
        System.out.println("Cannot Walk");
    }
}

interface TalkableRobot {
    void talk();
}

class NormalTalk implements TalkableRobot {
    @Override
    public void talk() {
        System.out.println("Talking Normally");
    }
}

class NoTalk implements TalkableRobot {
    @Override
    public void talk() {
        System.out.println("Cant talk");
    }
}

interface FlyableRobot {
    void fly();
}

class NormalFly implements FlyableRobot {
    @Override
    public void fly() {
        System.out.println("Flying Normally");
    }
}

class NoFly implements FlyableRobot {
    @Override
    public void fly() {
        System.out.println("Cant fly");
    }
}

abstract class Robot {
    protected WalkableRobot walkBehavior;
    protected TalkableRobot talkBehavior;
    protected FlyableRobot flyBehavior;

    public Robot(WalkableRobot w, TalkableRobot t, FlyableRobot f) {
        this.walkBehavior = w;
        this.talkBehavior = t;
        this.flyBehavior = f;
    }

    public void walk() {
        walkBehavior.walk();
    }

    public void talk() {
        talkBehavior.talk();
    }

    public void fly() {
        flyBehavior.fly();
    }

    public abstract void projection();
}

class CompanionRobot extends Robot {
    public CompanionRobot(WalkableRobot w, TalkableRobot t, FlyableRobot f) {
        super(w, t, f);
    }

    @Override
    public void projection() {
        System.out.println("Displaying friendly companion features...");
    }
}

class WorkerRobot extends Robot {
    public WorkerRobot(WalkableRobot w, TalkableRobot t, FlyableRobot f) {
        super(w, t, f);
    }

    public void projection() {
        System.out.println("Displaying worker efficiency stats...");
    }
}

public class Strategy_Design_Pattern {
    public static void main(String[] args) {
        Robot robot1 = new CompanionRobot(new NormalWalk(), new NormalTalk(), new NoFly());
        robot1.walk();
        robot1.talk();
        robot1.fly();
        robot1.projection();

        System.out.println("------------------");

        Robot robot2 = new WorkerRobot(new NoWalk(), new NoTalk(), new NormalFly());
        robot2.walk();
        robot2.talk();
        robot2.fly();
        robot2.projection();
    }
}