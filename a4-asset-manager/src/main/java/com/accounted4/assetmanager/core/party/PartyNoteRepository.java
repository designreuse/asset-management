package com.accounted4.assetmanager.core.party;

import com.accounted4.assetmanager.entity.PartyNote;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author gheinze
 */
public interface PartyNoteRepository extends JpaRepository<PartyNote, Long> {
}
