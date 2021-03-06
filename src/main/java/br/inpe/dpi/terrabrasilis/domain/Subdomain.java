package br.inpe.dpi.terrabrasilis.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * @author jether
 *
 */
@Document(collection = "subdomain")
public final class Subdomain implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	@Indexed(unique = true)
	private String name;
	private String description;
	@Indexed(unique = true)
	private String domain;
	private boolean enabled;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime created;
	
	public Subdomain() {
		this.created = LocalDateTime.now();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	@Override
	public int hashCode() {		
		return Objects.hash(id, name, domain);
	}

	@Override
	public boolean equals(Object other) {
		if (this == other)
			return true;
		if (other == null)
			return false;
		if (getClass() != other.getClass())
			return false;
		Subdomain subdomain = (Subdomain) other;
		return Objects.equals(id, subdomain.id)
					&& Objects.equals(name, subdomain.name)
					&& Objects.equals(domain, subdomain.domain);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Subdomain [name=");
		builder.append(name);
		builder.append(", description=");
		builder.append(description);
		builder.append(", domain=");
		builder.append(domain);
		builder.append(", enabled=");
		builder.append(enabled);
		builder.append("]");
		return builder.toString();
	}
	
	
}
