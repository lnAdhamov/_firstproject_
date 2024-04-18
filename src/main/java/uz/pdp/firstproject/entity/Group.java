package uz.pdp.firstproject.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;


@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "groups")
public class Group extends BaseEntity {
    private String name;
}
