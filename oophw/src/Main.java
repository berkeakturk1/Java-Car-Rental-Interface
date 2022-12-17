public class Main {
    public static void main(String[] args) {
        Client c = new Client();
        c.append("p", "first");
        c.append("d" , "last");
        c.increment();
        c.addAmount(3000);
        c.generateList();
        String im = "C:\\Users\\aktrk\\IdeaProjects\\oophw\\src\\assets\\carstock.jpg";
        int price = 1000;
        SelectionGUI sl = new SelectionGUI(price, im);
    }
}