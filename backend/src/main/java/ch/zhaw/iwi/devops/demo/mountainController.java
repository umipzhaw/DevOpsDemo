package ch.zhaw.iwi.devops.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import com.fasterxml.jackson.databind.deser.std.StringArrayDeserializer;

@CrossOrigin
@RestController

public class mountainController {
    private Map<Integer, mountain> mountains = new HashMap<Integer, mountain>();

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        this.mountains.put(1,new mountain(1, "Laax", "Graubünden"));
        this.mountains.put(2,new mountain(2, "Zermatt", "Wallis"));
        this.mountains.put(3,new mountain(3, "Andermatt", "Uri"));
        this.mountains.put(4,new mountain(4, "Engelberg", "Nidwalden"));
        this.mountains.put(5,new mountain(5, "Braunwald", "Glarus"));
        System.out.println("Init Data");
    }

    @GetMapping("/test")
    public String test() {
        return "ToDo app is up and running!";
    }

    @GetMapping("/services/ping")
    public String ping() {
        String languageCode = "de";
        return "{ \"status\": \"ok\", \"userId\": \"admin"+ "\", \"languageCode\": \"" + languageCode + "\",\"version\": \"0.0.1" + "\"}";
    }

    @GetMapping("/count")
    public int count() {
        return this.mountains.size();
    }

    @GetMapping("/services/mountains")
    public List<PathListEntry<Integer>> todo() {
        var result = new ArrayList<PathListEntry<Integer>>();
        for (var mountain : this.mountains.values()) {
            var entry = new PathListEntry<Integer>();
            entry.setKey(mountain.getId(), "todoKey");
            entry.setName(mountain.getTitle());
            entry.getDetails().add(mountain.getmountain_type());
            entry.setTooltip(mountain.getmountain_type());
            result.add(entry);
        }
        return result;
    }

    @GetMapping("/services/mountain/{id}")
    public mountain getTodo(@PathVariable Integer id) {
        return this.mountains.get(id);
    }

    @PostMapping("/services/mountain")
    public void createTodo(@RequestBody mountain mountains) {
        var newId = this.mountains.keySet().stream().max(Comparator.naturalOrder()).orElse(0) + 1;
        mountains.setId(newId);
        this.mountains.put(newId, mountains);
    }

    @PutMapping("/services/mountain/{id}")
    public void createTodo(@PathVariable Integer id, @RequestBody mountain mountains) {   
        mountains.setId(id);
        this.mountains.put(id, mountains);
    }

    @DeleteMapping("/services/mountain/{id}")
    public mountain deleteTodo(@PathVariable Integer id) {
        return this.mountains.remove(id);
    }


}

