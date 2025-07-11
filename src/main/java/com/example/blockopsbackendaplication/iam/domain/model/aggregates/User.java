package com.example.blockopsbackendaplication.iam.domain.model.aggregates;


import com.example.blockopsbackendaplication.iam.domain.model.valueobjects.EmailAddress;
import com.example.blockopsbackendaplication.iam.domain.model.valueobjects.Password;
import com.example.blockopsbackendaplication.iam.domain.model.valueobjects.PersonName;
import com.example.blockopsbackendaplication.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;


@Getter
@Entity
public class User extends AuditableAbstractAggregateRoot<User> {
    @NotBlank
    @Size(max = 50)
    @Column(unique = true)
    private String username;
    @Embedded
    @AttributeOverrides({@AttributeOverride(name="firstName",column = @Column(name = "first_name_manager")),
            @AttributeOverride(name="lastName",column = @Column(name="last_name_manager"))})
    private PersonName personName;
    @Embedded
    @AttributeOverrides({ @AttributeOverride(name="value",column = @Column(name="email_address_manager",unique = true))})
    private EmailAddress emailAddress;
    @Embedded
    @AttributeOverrides({@AttributeOverride(name="password", column = @Column(name="password_manager"))})
    private Password password;
    public String getStringEmail(){
        return  emailAddress.value();
    }
    public User(){}
    private String perfilRiesgo;
    private String preferencias;

    public User(String username, String firstName, String lastName, String emailAddress, String password, String perfilRiesgo, String preferencias) {
        this.personName = new PersonName(firstName, lastName);
        this.emailAddress = new EmailAddress(emailAddress);
        this.password = new Password(password);
        this.username = username;
        this.perfilRiesgo = perfilRiesgo;
        this.preferencias = preferencias;
    }

    // Constructor anterior para compatibilidad temporal
    public User(String username, String firstName, String lastName, String emailAddress, String password) {
        this(username, firstName, lastName, emailAddress, password, null, null);
    }



    public Password getPassword() {
        return password;
    }
}
