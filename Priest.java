/*
Класс Священник - наследник класса Заклинатель

Обучающийся: ШИТОВ Олег Владимирович, "Разработчик Python", поток 4544, будни, утро.  08.07.2023.
*/

class Priest extends Spirit {
    private int elixir;

    public Priest(String name, int health, int damage, int elixir) {
        super(name, health, damage);
        if (elixir < 0) {
            this.elixir = 0;
        } else if (elixir > 10) {
            this.elixir = 10;
        } else {
            this.elixir = elixir;
        }
    }

    public void influence() {
        System.out.println("Priest " + name + " influences with prayers.");
    }
    // @Override
    // public String getInfo() {
    // return super.getInfo();
    // }
}