package homework1;

public class Team {
    private Athlete[] athletes;
    private boolean[] finishes;

    public Team(Athlete a1, Athlete a2, Athlete a3, Athlete a4) {
        athletes = new Athlete[]{a1, a2, a3, a4};
        finishes = new boolean[athletes.length];
    }

    public Team(Athlete[] team) {
        athletes = team;
        finishes = new boolean[athletes.length];
    }

    public Athlete[] getAthletes() {
        return athletes;
    }

    public boolean[] getFinishes() {
        return finishes;
    }

    public void showResults() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < athletes.length; i++) {
            sb.append(athletes[i].toString());
            sb.append(" is ");
            sb.append(finishes[i] ? "" : "not ");
            sb.append("finished.\n");
        }
        System.out.println(sb);
    }
}
