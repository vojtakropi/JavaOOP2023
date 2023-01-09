package du11.src.main.java;

public class SauceFactory {
    public Sauces chooseSauce(String saucetexture){
        if (saucetexture == null || saucetexture.isEmpty())
            return null;
        return switch (saucetexture) {
            case "sweet" -> new HoneySauce();
            case "hot" -> new HotSauce();
            case "orange" -> new MustardSauce();
            default -> throw new IllegalArgumentException("Unknown taste " + saucetexture);
        };
    }
}
