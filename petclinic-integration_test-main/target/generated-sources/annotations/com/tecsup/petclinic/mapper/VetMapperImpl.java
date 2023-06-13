package com.tecsup.petclinic.mapper;

import com.tecsup.petclinic.domain.VetTO;
import com.tecsup.petclinic.entities.Vet;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-13T11:38:46-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.7 (Eclipse Adoptium)"
)
@Component
public class VetMapperImpl implements VetMapper {

    @Override
    public Vet toVet(VetTO vetTO) {

        Vet vet = new Vet();

        if ( vetTO != null ) {
            vet.setId( vetTO.getId() );
            vet.setFirstName( vetTO.getFirstName() );
            vet.setLastName( vetTO.getLastName() );
        }

        return vet;
    }

    @Override
    public VetTO toVetTO(Vet vet) {

        VetTO vetTO = new VetTO();

        if ( vet != null ) {
            vetTO.setId( vet.getId() );
            vetTO.setFirstName( vet.getFirstName() );
            vetTO.setLastName( vet.getLastName() );
        }

        return vetTO;
    }

    @Override
    public List<VetTO> toVetTOList(List<Vet> vetList) {
        if ( vetList == null ) {
            return new ArrayList<VetTO>();
        }

        List<VetTO> list = new ArrayList<VetTO>( vetList.size() );
        for ( Vet vet : vetList ) {
            list.add( toVetTO( vet ) );
        }

        return list;
    }

    @Override
    public List<Vet> toVetList(List<VetTO> vetTOList) {
        if ( vetTOList == null ) {
            return new ArrayList<Vet>();
        }

        List<Vet> list = new ArrayList<Vet>( vetTOList.size() );
        for ( VetTO vetTO : vetTOList ) {
            list.add( toVet( vetTO ) );
        }

        return list;
    }
}
