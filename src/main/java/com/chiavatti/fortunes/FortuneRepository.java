package com.chiavatti.fortunes;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;

import org.springframework.stereotype.Repository;

@Repository
public class FortuneRepository {

    private AmazonDynamoDB dynamoDB;

    public FortuneRepository(AmazonDynamoDB dynamoDB) {
        this.dynamoDB = dynamoDB;
    }

    public String getFortune() {
        DynamoDB db = new DynamoDB(dynamoDB);
        Table table = db.getTable("Fortunes");
        Item item = table.getItem("id", (int)(Math.random()*3 + 1));
        return item.getJSON("text");
    }
}