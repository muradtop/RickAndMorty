package com.example.kotlin1hm2ram.ui.fragments.characters

import com.example.kotlin1hm2ram.base.BaseViewModel
import com.example.kotlin1hm2ram.data.repositories.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val repository: CharacterRepository,
) : BaseViewModel() {

    fun fetchCharacters() = repository.fetchCharacters()

    fun fetchCharacterID(id: Int) = repository.fetchCharacterID(id)
}