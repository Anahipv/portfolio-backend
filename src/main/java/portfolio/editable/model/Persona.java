
package portfolio.editable.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Persona implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    
    private String name;
    private String jobTitle;
    private String imageUrl;
    private String githubUrl;
    private String linkedinUrl;

    public Persona() {
    }

    public Persona(Long id, String name, String jobTitle, String imageUrl, String githubUrl, String linkedinUrl) {
        this.id = id;
        this.name = name;
        this.jobTitle = jobTitle;
        this.imageUrl = imageUrl;
        this.githubUrl = githubUrl;
        this.linkedinUrl = linkedinUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getGithubUrl() {
        return githubUrl;
    }

    public void setGithubUrl(String githubUrl) {
        this.githubUrl = githubUrl;
    }

    public String getLinkedinUrl() {
        return linkedinUrl;
    }

    public void setLinkedinUrl(String linkedinUrl) {
        this.linkedinUrl = linkedinUrl;
    }
    
    
    
    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
    
    
            
}
