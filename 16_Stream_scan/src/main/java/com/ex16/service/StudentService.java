package com.ex16.service;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.ex16.entity.Student;
import com.ex16.repository.StudentRepository;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;


import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private static final Logger logger = LogManager.getLogger(StudentService.class);

    @Autowired
    StudentRepository studentRepository;

    public void LoadData() {

        try {
            JsonElement root = new JsonParser().parse(new FileReader(StudentService.class.getClassLoader().getResource("student.json").getPath()));
            root.getAsJsonArray().forEach(jsonElement -> {
                JsonObject jsonObject = jsonElement.getAsJsonObject();
                Long id = Long.parseLong(jsonObject.get("id").toString());
                String name = jsonObject.get("name").toString();
                int age = Integer.parseInt(jsonObject.get("age").toString());
                String gender = jsonObject.get("gender").toString();
                studentRepository.save(new Student(id, name, age, gender));
            });

            Student student = studentRepository.findById(1L);
            logger.info(student);

        } catch (FileNotFoundException ex) {
            logger.error(ex.getMessage());
        }
    }

    public void List() {
        logger.info("\n\nList :");
        logger.info(studentRepository.all().values().stream().collect(Collectors.toList()));
    }

    public void ForEach() {
        logger.info("\n\nForEach :");
        studentRepository.all().forEach((k, v) -> logger.info("Key : " + k + ", Value : " + v));
    }

    public void GroupBy() {
        logger.info("\n\nGroupBy :");

        Map<String, Optional<Integer>> result = studentRepository.all().values().stream()
                .collect(Collectors.groupingBy(
                        Student::getGender, // GROUP BY gender
                        Collectors.mapping(Student::getAge, Collectors.maxBy(Integer::compare)) // MAX(age)
                ));

        // Print
        result.entrySet().forEach(entry
                -> logger.info(String.format("Gender: %s | Max Age: %s", entry.getKey(), entry.getValue()))
        );
    }

    public void Distinct() {
        logger.info("\n\nDistinct :");

        List<Integer> ages = studentRepository.all().values().stream()
                .map(Student::getAge)
                .distinct() // DISTINCT
                .sorted()
                .collect(Collectors.toList());

        // Print
        System.out.println(String.format("Ages : %s", ages.stream().map(Object::toString).collect(Collectors.joining(", "))));
    }

    public void InnerJoin() {
        logger.info("\n\nInnerJoin :");

        String[] t1 = {"A", "B", "C"};
        String[] t2 = {"B", "C", "D"};

        // CROSS JOIN
        List<Object> list
                = Stream.of(t1).flatMap(x -> Arrays.stream(t2).filter(y -> Objects.equals(x, y))).collect(Collectors.toList());

        // Print
        list.forEach(entry -> logger.info(entry));
    }

}
