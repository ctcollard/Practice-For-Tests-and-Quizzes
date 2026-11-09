public class Competitor {
    private String name;
    private int competitorID;
    private int age;
    private int wins;
    private int losses;
    private boolean disqualified;

    public Competitor(String name, int competitorID, int age, int wins, int losses, boolean disqualified) {
        this.name = name;
        this.competitorID = competitorID;
        this.age = age;
        this.wins = wins;
        this.losses = losses;
        this.disqualified = disqualified;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !(other instanceof Competitor)) {
            return false;
        }
        Competitor otherCompetitor = (Competitor) other;
        return this.competitorID == otherCompetitor.competitorID;
    }

    public double getWinPercentage() {
        if (wins > 0 || losses > 0) {
            return ((double) wins / (wins + losses)) * 100; 
        }
        if (wins == 0 && losses == 0) {
            return 0.0;
        }
        return 0.0;
    }
    
    public boolean isEligibleForChampionship() {
        if (disqualified == false && (wins + losses) >= 5 && getWinPercentage() >= 70.0 && age < 18) {
            return true;
        }
        else if ((disqualified == false && (wins + losses) >= 5 && getWinPercentage() >= 70.0 && age >= 18 && wins >= 10)) {
            return true;
        }
        else {
            return false;
        }
    }

    public String getDivision() {
        if (disqualified == true) {
            return "Ineligible";
        }
        else if (age < 13) {
            return "Junior";
        }
        else if (age >= 13 && age <= 17) {
            return "Youth";
        }
        else if (age >= 18 && getWinPercentage() >= 80) {
            return "Elite";
        }
        else {
            return "Open";
        }
    }

    
}