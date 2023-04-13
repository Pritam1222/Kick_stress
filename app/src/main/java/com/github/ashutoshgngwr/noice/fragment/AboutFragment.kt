package com.github.ashutoshgngwr.noice.fragment

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.github.ashutoshgngwr.noice.BuildConfig
import com.github.ashutoshgngwr.noice.NoiceApplication
import com.github.ashutoshgngwr.noice.R
import com.github.ashutoshgngwr.noice.ext.launchInCustomTab
import mehdi.sakout.aboutpage.AboutPage
import mehdi.sakout.aboutpage.Element

class AboutFragment : Fragment() {

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return AboutPage(context).run {
      setImage(R.drawable.app_banner_4)
      setDescription(getString(R.string.app_description))
      addItem(
        buildElement(
          R.drawable.ic_about_version,
          "v${BuildConfig.VERSION_NAME}",
          getString(R.string.app_changelog_url)
        )
      )

      addGroup(getString(R.string.created_by))
      addGitHub(creatorGithub_1, creatorGithub_1)
      addGitHub(creatorGithub_2, creatorGithub_2)
      addGitHub(creatorGithub_3, creatorGithub_3)
      addGitHub(creatorGithub_4, creatorGithub_4)
      addGitHub(creatorGithub_5, creatorGithub_5)
      create()
    }
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    NoiceApplication.of(requireContext())
      .analyticsProvider
      .setCurrentScreen("about", AboutFragment::class)
  }

  private fun buildElement(
    @DrawableRes iconId: Int,
    @StringRes titleResId: Int,
    @StringRes urlResId: Int
  ): Element {
    return buildElement(iconId, getString(titleResId), getString(urlResId))
  }

  private fun buildElement(@DrawableRes iconId: Int, title: String, url: String): Element {
    return Element(title, iconId)
      .setAutoApplyIconTint(true)
      .setOnClickListener { Uri.parse(url).launchInCustomTab(requireContext()) }
  }

  companion object {
    private const val creatorGithub_1 = "Pritam1222"
    private const val creatorGithub_2 = "yashchougule108"
    private const val creatorGithub_3 = "Anjali00Parbhane"
    private const val creatorGithub_4 = "vaishnavi126"
    private const val creatorGithub_5 = "rushali2607"
  }
}
