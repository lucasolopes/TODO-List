public enum Prioridade {
    ONE("1"),
    TWO("2"),
    TREE("3"),
    FOUR("4"),
    FIVE("5");

    public final String label;

    private Prioridade(String label) {
        this.label = label;
    }

    @Override
    public String toString() {

        return this.label;
    }
}
