package com.FSAD_SDP_10.library_backend.config;

import com.FSAD_SDP_10.library_backend.model.Book;
import com.FSAD_SDP_10.library_backend.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initDatabase(BookRepository repository) {
        return args -> {
            // Clears database on every restart so you don't get 100+ duplicates
            repository.deleteAll();
            
            System.out.println("🚀 Seeding Global Resource Library...");

            repository.saveAll(List.of(
                // 1. Engineering & Technology
                new Book(null, "Introduction to Computer Science", "Dr. A. Smith", "Computer Science"),
                new Book(null, "Deep Learning & Neural Networks", "Stuart Russell", "AI & Machine Learning"),
                new Book(null, "Network Security Fundamentals", "William Stallings", "Cyber Security"),
                new Book(null, "Data Mining & Predictive Analytics", "Ian H. Witten", "Data Science & Analytics"),
                new Book(null, "Modern Software Engineering", "Ian Sommerville", "Software Engineering"),
                new Book(null, "Cloud Architecture Patterns", "Bill Wilder", "Cloud Computing"),
                
                // 2. Pure Sciences & Math
                new Book(null, "Discrete Mathematics and Its Applications", "Kenneth Rosen", "Mathematics"),
                new Book(null, "Concepts of Physics Vol 1", "H.C. Verma", "Physics"),
                new Book(null, "Molecular Biology of the Gene", "James Watson", "Biotechnology"),
                
                // 3. Design & Creative
                new Book(null, "Don't Make Me Think: UI/UX", "Steve Krug", "UI/UX Design"),
                new Book(null, "The Elements of Graphic Design", "Alex White", "Graphic Design"),
                new Book(null, "Unity Game Development in 24 Hours", "Mike Geig", "Game Development"),
                
                // 4. Business & Humanities
                new Book(null, "Principles of Management", "Pankaj Chandra", "Business Management"),
                new Book(null, "Digital Marketing Strategy", "Simon Kingsnorth", "Digital Marketing"),
                new Book(null, "Financial Accounting & Reporting", "Barry Elliott", "Finance & Accounting"),
                new Book(null, "History of English Literature", "Edward Albert", "English Literature"),
                new Book(null, "Introduction to Psychology", "James Kalat", "Psychology")
            ));

            System.out.println("✅ " + repository.count() + " Books Seeded Successfully!");
        };
    }
}