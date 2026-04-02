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
            System.out.println("🚀 Preloading Data to InfoDepot...");
            repository.saveAll(List.of(
                new Book(null, "Operating Systems", "Silberschatz"),
                new Book(null, "Java: The Complete Reference", "Herbert Schildt"),
                new Book(null, "Digital Logic & Computer Design", "M. Morris Mano")
            ));
            System.out.println("✅ Database Seeded Successfully!");
        };
    }
}