package com.pluralsight.NorthwindTradersSpringBoot.DAO.Impl;

import com.pluralsight.NorthwindTradersSpringBoot.DAO.Interfaces.IProductDAO;
import com.pluralsight.NorthwindTradersSpringBoot.DAO.models.Product;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class SimpleProductDAO implements IProductDAO
{
    private final List<Product> products;

    public SimpleProductDAO()
    {
        this.products = new ArrayList<>();

        products.add(new Product(1, "Mountain Dew", 1, 1.50));
        products.add(new Product(2, "Cheddar", 4, 5.50));
        products.add(new Product(3, "Steak", 6, 20.50));
    }

    @Override
    public Product insert(Product product)
    {
        int maxId = 0;
        for (Product t : products)
        {
            if (t.getProductId() > maxId)
            {
                maxId = t.getProductId();
            }
        }
        product.setProductId(maxId + 1);
        products.add(product);
        return product;
    }

    @Override
    public List<Product> getAll()
    {
        return products;
    }

    private int getProductIndex(int productId)
    {
        for (int i = 0; i < products.size(); i++)
        {
            if (products.get(i).getProductId() == productId)
            {
                return i;
            }
        }
        return -1;
    }
}
