package com.example.homescreen

import com.example.core.ActionState
import com.example.domain.models.ExampleModel

data class HomeViewState(val examples: ActionState<List<ExampleModel>> = ActionState(), val otherText:String = "testString")
