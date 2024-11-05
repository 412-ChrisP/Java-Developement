package YearUp.pluralsight;

import YearUp.pluralsight.finance.Valuable;

import java.util.ArrayList;
import java.util.List;

public class Portfolio
{
    private final String name;
    private final String owner;
    private final List<Valuable> assets;

    public Portfolio(String name, String owner)
    {
        this.name = name;
        this.owner = owner;
        this.assets = new ArrayList<>();
    }

    public void add(Valuable asset)
    {
        assets.add(asset);
    }

    public double getValue()
    {
        double total = 0;
        for (Valuable asset : assets)
        {
            total += asset.getValue();
        }
        return total;
    }

    public Valuable getMostValuable()
    {
        Valuable most = assets.getFirst();
        for (Valuable asset : assets)
        {
            if (asset.getValue() > most.getValue())
            {
                most = asset;
            }
        }
        return most;
    }

    public Valuable getLeastValuable()
    {
        Valuable least = assets.getFirst();
        for (Valuable asset : assets)
        {
            if (asset.getValue() < least.getValue())
            {
                least = asset;
            }
        }
        return least;
    }

    public String getName()
    {
        return name;
    }

    public String getOwner()
    {
        return owner;
    }
}