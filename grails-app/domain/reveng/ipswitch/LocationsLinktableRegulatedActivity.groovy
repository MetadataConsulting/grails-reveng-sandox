package reveng.ipswitch

import org.apache.commons.lang.builder.EqualsBuilder
import org.apache.commons.lang.builder.HashCodeBuilder

class LocationsLinktableRegulatedActivity implements Serializable {

	String locationId
	String regulatedActivityCode
	String name
	Date apiCallDate
	Date importDate
	Date createdDate

	int hashCode() {
		def builder = new HashCodeBuilder()
		builder.append locationId
		builder.append regulatedActivityCode
		builder.append name
		builder.append apiCallDate
		builder.append importDate
		builder.append createdDate
		builder.toHashCode()
	}

	boolean equals(other) {
		if (other == null) return false
		def builder = new EqualsBuilder()
		builder.append locationId, other.locationId
		builder.append regulatedActivityCode, other.regulatedActivityCode
		builder.append name, other.name
		builder.append apiCallDate, other.apiCallDate
		builder.append importDate, other.importDate
		builder.append createdDate, other.createdDate
		builder.isEquals()
	}

	static mapping = {
		id composite: ["locationId", "regulatedActivityCode", "name", "apiCallDate", "importDate", "createdDate"]
        locationId column: 'locationId'
        regulatedActivityCode column: 'regulatedActivityCode'
        version false
	}

	static constraints = {
		locationId maxSize: 15
		regulatedActivityCode maxSize: 50
		name nullable: true
		// createdDate unique: ["regulatedActivityCode", "locationID"]
	}
}
